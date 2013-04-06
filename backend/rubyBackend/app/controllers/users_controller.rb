class UsersController < ApplicationController

  # GET /users/login

  # app sends in username and password and geoX and geoY (all strings)
  # controller finds the first occurance of username param, checks if the next param
  # matches the password and calls model method to get the number of friends,
  # the number of friends online, and the number of messages
  # return successful json of values, else return unsuccessful

  #done
  #http://rusocial-rusocialbackend.rhcloud.com/users/login.json?user=Chris&password=Chan&geoX=5&geoY=6
  #============================ METHOD 1 ===================================#
  def login
    if params[:user]
      if params[:password]
        if params[:geoX]
          if params[:geoY]
            #everything went thru well, - this part is bulk of program logic... continue

            if user = User.find_by_username(params[:user]) #now search if there is user match
              if user.correct_password(params[:password])
                #core in here

                #update geolocations
                user.update_geo_locations(params[:geoX], params[:geoY])

                #get number of online ppl globally
                num_online_all = user.get_num_online_globally(params[:geoX], params[:geoY])

                #get number of friends
                num_friend = user.get_num_friends

                #get number of messages
                num_message = user.get_num_messages

                #get number of friends online
                num_friends_online = user.get_num_friends_online

                #get user email
                user_email = user.get_email

                #make hash
                #@output_hash = Hash.new
                #@output_hash["num_online_all"] = num_online_all
                #@output_hash["num_friends"] = num_friend
                #@output_hash["num_messages"] = num_message
                #@output_hash["num_friends_online"] = num_friends_online
                #@output_hash["user_email"] = user_email

                #output to caller   needs to be FIXED JSON OBJECT ONLY
                respond_to do |format|
                  format.json { render :json => "[{\"num_online_all\":\"#{num_online_all}\"},{\"num_friends\":\"#{num_friend}\"},{\"num_messages\":\"#{num_message}\"},{\"num_friends_online\":\"#{num_friends_online}\"},{\"user_email\":\"#{user_email}\"}]" }
                  #format.json { render json: @output_hash.to_json }
                  #format.json { render :json => num_friend, num_message, num_friends_online }
                end
              else
                # incorrect password
                respond_to do |format|
                  format.json { render :json => '[{"Status":"Failure"}]' }
                  #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
                end
              end
            else
              #no user found
              respond_to do |format|
                format.json { render :json => '[{"Status":"Failure"}]' }
                #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
              end
            end


          else
            #no geoY
            respond_to do |format|
              format.json { render :json => '[{"Status":"Failure"}]' }
              #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
            end
          end
        else
          #no geoX
          respond_to do |format|
            format.json { render :json => '[{"Status":"Failure"}]' }
            #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
          end
        end
      else
        #no password
        respond_to do |format|
          format.json { render :json => '[{"Status":"Failure"}]' }
          #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
        end
      end
    else
      #no user
      respond_to do |format|
        format.json { render :json => '[{"Status":"Failure"}]' }
        #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
      end
    end
  end

  #============================ METHOD 1 ===================================#


  # GET /users/look_around

  # app sends in geoX and geoY (all strings)
  # controller calls user model method to and for each user's geoX and geoY, see if it is within +-10 degrees away,
  # return successful json username, distance, status, and email in json otherwise return unsuccessful

  #============================ METHOD 2 ===================================#
  def look_around
    if params[:geoX] # see if param has geoX string
      if params[:geoY] # see if param has geoY string
                       #both geoX and geoY is is the params

        @users = User.all #grab all users
        @array_users ||= Array.new # make a new array, see if it is possible ? ||
        @users.each do |user| #for each user, check if they're nearby
          if user.check_nearby2(params[:geoX], params[:geoY])
            @array_users.push(user)
          end
        end #end of looping thru every user       #return array_users in JSON

        respond_to do |format|
          # format.json { render json: @array_users }   #shows everything
          format.json { render :json => @array_users.to_json(:only => [:username, :email, :status_message, :geoX, :geoY]) }
          #missing distance
        end
      else
        #no geoY but geoX exists
        respond_to do |format|
          format.json { render :json => '[{"Status":"Failure"}]' }
          #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
        end
      end

    else
      #no geoY but geoX exists
      respond_to do |format|
        format.json { render :json => '[{"Status":"Failure"}]' }
        #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
      end

    end

  end


  #============================ METHOD 2 ===================================#


  # GET /users/find_friends
  #done

  # app sends in username
  # controller finds the first occurance of username param, calls model method to populate @friends array
  # return successful json of friends, friend's status message, status and email, otherwise return unsuccessful

  #============================ METHOD 3 ===================================#
  def find_friends
    if params[:user]
      if user = User.find_by_username(params[:user])
        #@list_of_friends = user.grab_user_from_friends
        #return everything inside list of friends

        @users = user.grab_friend_from_users

        respond_to do |format|
          #format.json { render :json  => '{"Status":"Success"}' }
          format.json { render json: @users }
          #format.json { render json: @users.to_json(:only => [:username, :status_message, :state]) }                 #json: @list_of_friends.to_json, changed
          #format.json { render :json => @array_users.to_json(:only => [:username, :email, :status_message, :geoX, :geoY]) }
        end
      else
        respond_to do |format|
          format.json { render :json => '[{"Status":"Failure"}]' }
          #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
        end
      end

    else
      respond_to do |format|
        format.json { render :json => '[{"Status":"Failure"}]' }
        #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
      end
    end


  end

  #============================ METHOD 3 ===================================#


  # GET /users/get_messages

  # app sends in username
  # controller finds the first occurance of username param, calls model method to populate @messages array (first get user_id, then traverse through message array and see which message matches user_id, put it in array)
  # return successful json of sender(string), bodyMessage(string) and date in json, otherwise return unsuccessful

  #============================ METHOD 4 ===================================#
  def get_messages
    if params[:user]
      if user = User.find_by_username(params[:user])
        @list_of_messages = user.grab_messages
        #return everything inside list of friends
        respond_to do |format|
          format.json { render json: @list_of_messages }
        end
      else
        respond_to do |format|
          format.json { render :json => '[{"Status":"Failure"}]' }
          #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
        end
      end


    else
      respond_to do |format|
        format.json { render :json => '[{"Status":"Failure"}]' }
        #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
      end
    end
  end

  #============================ METHOD 4 ===================================#


  # GET /users/send_message

  # app sends in username, sender, message and date
  # controller calls finds the first occurance of username param, gets the corresponding id and creates a new message instance and supplies the id, sender,
  # return success message, else return failure message


  #============================ METHOD 5 ===================================#


  #method fully functional http://rusocial-rusocialbackend.rhcloud.com/users/send_message.json?user=Chris&sender=Kelvin&message=helloMak&date=Apr2013
  def send_message

    if params[:user]
      if params[:sender]
        if params[:message]
          if params[:date]
            #main logic
            if user = User.find_by_username(params[:user]) #grab user
              user.create_new_message(params[:sender], params[:message], params[:date])
              respond_to do |format|
                format.json { render :json => '[{"Status":"Success"}]' }
                #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
              end
            else
              respond_to do |format|
                format.json { render :json => '[{"Status":"Failure"}]' }
                #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
              end
            end

          end
        else
          respond_to do |format|
            format.json { render :json => '[{"Status":"Failure"}]' }
            #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
          end
        end
      else
        respond_to do |format|
          format.json { render :json => '[{"Status":"Failure"}]' }
          #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
        end
      end
    else
      respond_to do |format|
        format.json { render :json => '[{"Status":"Failure"}]' }
        #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
      end
    end


  end

  # GET /users/make_a_friend
  # http://rusocial-rusocialbackend.rhcloud.com/users/make_a_friend.json?user=Chris&friend=Yoma&state=pending
  # app sends in username, friend, state
  # controller calls finds the first occurance of username param, gets the corresponding id and creates a new friend and supplies the friend and state
  # return success message, else return failure message

  #needed extra
  def make_a_friend

    if params[:user]
      if params[:friend]
        if params[:state]
          #main logic
          if user = User.find_by_username(params[:user]) #grab user
            user.create_new_friend(params[:friend], params[:state])
            respond_to do |format|
              format.json { render :json => '[{"Status":"Success"}]' }
              #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
            end
          else
            respond_to do |format|
              format.json { render :json => '[{"Status":"Failure"}]' }
              #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
            end
          end

        end

      else
        respond_to do |format|
          format.json { render :json => '[{"Status":"Failure"}]' }
          #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
        end
      end
    else
      respond_to do |format|
        format.json { render :json => '[{"Status":"Failure"}]' }
        #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
      end
    end


  end

  #============================ METHOD 5 ===================================#


  #============================ METHOD 6 ===================================#
  #this is fully functional now
  #to use
  # http://rusocial-rusocialbackend.rhcloud.com/users/change_user_pref.json?status_message=Hi&user=Richard

  # GET /users/change_user_pref

  # app sends in username and statusMessage eg. "tired and sleepy"
  # controller calls model method and updates statusmessage,
  # return successful if updated, unsuccessful if not
  def change_user_pref


    if params[:user] # means if there is a http parameter which matches user string
      if  params[:status_message] #search for param matching status_message
        if user = User.find_by_username(params[:user]) #now search if there is user match
          user.update_status_message(params[:status_message]) #if yes user then put status message update
          respond_to do |format|
            format.json { render :json => '[{"Status":"Success"}]' }
            #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
          end
        else
          respond_to do |format|
            format.json { render :json => '[{"Status":"Failure"}]' }
            #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
          end
        end

      else
        respond_to do |format|
          format.json { render :json => '[{"Status":"Failure"}]' }
          #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }
        end
      end
    else
      respond_to do |format|
        format.json { render :json => '[{"Status":"Failure"}]' }
        #format.json { render :status => :unprocessable_entity }#, '{"Status":"Failure"}' }

        #format.json { render :json => :status }#, '{"Status":"Failure"}' }
      end
    end


  end

  #extra get a username, return pending friends
  # http://rusocial-rusocialbackend.rhcloud.com/users/get_friends_pending.json?user=Chris

  #
  def get_friends_pending
    if params[:user]
      if user = User.find_by_username(params[:user])
        # found a user
        @list_of_pending_friends = user.grab_pending_friends
        respond_to do |format|
          format.json { render :json => @list_of_pending_friends }
        end
      else
        # no user

        respond_to do |format|
          format.json { render :json => '[{"Status":"Failure"}]' }
        end
      end
    else
      #bad param
      respond_to do |format|
        format.json { render :json => '[{"Status":"Failure"}]' }
      end
    end
  end


  #tester for me
  def json_message_tester

    @users = User.all

    respond_to do |format|
      format.json { render :json => @users.to_json }
    end

  end

  #tester for me
  def json_message_default

    @users = User.all

    respond_to do |format|
      format.json { render :json => @users }
    end

  end


  #tester for me
  def json_message_hash1

    @users = User.all

    respond_to do |format|
      format.json { render :json => "{Hash[@users.flatten],0}" }
    end

  end


  #tester for me
  def json_message_hash2

    @users = User.all

    respond_to do |format|
      format.json { render :json => Hash[@users.map { |key, value| [key, value] }] }
    end

  end


  ##AUTO GENERATED DEFs BELOW

  # GET /users
  # GET /users.json
  def index
    @users = User.all

    respond_to do |format|
      format.html # index.html.erb
                  #format.json { render :json => Hash[*@users.flatten] }

      format.json { render json: @users }
    end
  end

  # GET /users/1
  # GET /users/1.json
  def show
    @user = User.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @user }
      #format.json { render :json => Hash[*@user.flatten] }        #changed from scaffold for mak's plugin
      #format.json { render :json => Hash[@user.map { |key, value| [key, value] }] }
    end
  end

  # GET /users/new
  # GET /users/new.json
  def new
    @user = User.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @user }
    end
  end

  # GET /users/1/edit
  def edit
    @user = User.find(params[:id])
  end

  # POST /users
  # POST /users.json
  def create
    @user = User.new(params[:user])

    respond_to do |format|
      if @user.save
        format.html { redirect_to @user, notice: 'User was successfully created.' }
        format.json { render json: @user, status: :created, location: @user }
      else
        format.html { render action: "new" }
        format.json { render json: @user.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /users/1
  # PUT /users/1.json
  def update
    @user = User.find(params[:id])

    respond_to do |format|
      if @user.update_attributes(params[:user])
        format.html { redirect_to @user, notice: 'User was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @user.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /users/1
  # DELETE /users/1.json
  def destroy
    @user = User.find(params[:id])
    @user.destroy

    respond_to do |format|
      format.html { redirect_to users_url }
      format.json { head :no_content }
    end
  end
end
