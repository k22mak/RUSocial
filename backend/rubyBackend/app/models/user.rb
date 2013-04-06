class User < ActiveRecord::Base
  attr_accessible :email, :geoX, :geoY, :password, :status, :status_message, :username
  has_many :messages, :dependent => :destroy
  has_many :friends, :dependent => :destroy


  #update status message
  def update_status_message(updated_message)
    write_attribute(:status_message, updated_message) #using self now more often
    self.save
  end


  #NEED PROF TO HELP
  #for the   def look_around to see if a particular user is near x and y decimal
  def check_nearby(x, y)

    #buffer_x = 5.0
    #buffer_y = 5.0
    #foreign_x = x.to_s.to_f
    #foreign_y = y.to_s.to_f

    #own_x = :geoX.to_s.to_f
    #own_y = :geoY.to_s.to_f

    #difference_x1 = foreign_x - buffer_x
    #difference_x2 = foreign_x + buffer_x
    #difference_y1 = foreign_y - buffer_y
    #difference_y2 = foreign_y + buffer_y

    #check if geoX and geoY of the user is in between x
    #if ((:geoX > difference_x1)
    # && (own_x < difference_x2)
    #&& (own_y > difference_y1) && (own_y < difference_y2))
    return true
    #else
    #  return false
    #end
    #uncommenet out and recompile , it only returns []
    #if validates_numericality_of(:geoX, :less_than_or_equal_to => x)
  end

  #for login - is the password the same as pass - the value passed in?
  def correct_password(pass)
    if pass == self.password
      return true
    else
      return false
    end

  end

  #update geo locations
  def update_geo_locations(x,y)
    self.geoX = x
    self.geoY = y
    self.save
  end

  #get_email
  def get_email
    return self.email
  end

  #retrieve num of friends
  def get_num_friends
    return self.friends.size
  end

  #retrieve num of messages
  def get_num_messages
    return self.messages.size
#    msg =Message.new(:message => "mymsg", :body =>  )
#msg.save
  end


  #retrieve num of friends online
  def get_num_friends_online

    #self.messages.find(:all, :condition=>[status =?, online ])
    @all_friends = self.friends.all #grab all friends
    @all_users = User.find_all_by_status("Online") #grab everyone in User table whos online
    @counter ||= Array.new #make a counter

    @all_friends.each do | friend |      # 9 friend objects
      @all_users.each do | stranger |           # 4 users by Online
        if stranger[:username] == friend[:friend]     # problem lies here nvm, its good. GREAT!
          @counter.push(stranger)
        end
      end
    end

    #return the counter
    return @counter.size
  end

  def get_username  #this code is incorrect
    return :username
  end
  #retrieve num of ppl online
  def self.get_num_online_globally

    #self.messages.find(:all, :condition=>[status =?, online ])
    @all_users = User.find_all_by_status("Online") #grab all people who are online
    #@counter ||= Array.new #make a counter

    #@all_users.each do | stranger |
     #     if stranger.get_username.upcase == "online".upcase
     #       @counter.push(stranger)
     #     end

    #end
    #return the size
    return @all_users.size # @counter.size
  end

  #### I DUNNO HOW TO ACCESS OR CREATE OR MANIPULATE MY RECORD OF FRIENDS/MESSAGES             nvm i got it
  #helper for find friends of
 # def grab_user_from_friends
 #   #return self.friends.all
  #  @all_friends = self.friends.all #grab all friends
  #  @all_users = User.all #find_all_by_status("Online") #grab everyone in User table whos online
   # @counter ||= Array.new #make a counter

   # @all_friends.each do | friend |      # 9 friend objects
   #   @all_users.each do | stranger |           # 4 users by Online
    #    if stranger[:username] == friend[:friend]     # problem lies here nvm, its good. GREAT!       if strnager's name is same as friends name
    #      @counter.push(friend)
    #    end
    #  end
   # end

    #return the counter                                  #THESE TWO METHODS NEED TO BE REVAMPED, IT SHOULD ALGROTIGHM SHOULD BE FIRS TO FIND WHICH USERS MATCH THEN REUTRN them
    #return @counter
  #end

  #helper for find friends and their status messages
  def grab_friend_from_users

    @all_friends = self.friends.all #grab all friends
    @all_users = User.all #find_all_by_status("Online") #grab everyone in User table whos online
    @counter ||= Array.new #make a counter

    @all_friends.each do | friend |      # 9 friend objects
      @all_users.each do | stranger |           # 4 users by Online
        if stranger[:username] == friend[:friend]     # problem lies here nvm, its good. GREAT!       if strnager's name is same as friends name
          friend_state = Hash.new
          friend_state["state"] = friend.get_state
          @counter.push(stranger, friend_state)
        end
      end
    end

    #return the counter                                  #THESE TWO METHODS NEED TO BE REVAMPED, IT SHOULD ALGROTIGHM SHOULD BE FIRS TO FIND WHICH USERS MATCH THEN REUTRN them
    return @counter
  end

  #helper for find friends and get status_message
  def get_status_message
    return self.status_message
  end

  #helper for find messages of
  def grab_messages
    return self.messages.all
  end

  #helper for get pending firends
  def grab_pending_friends

    @all_friends = self.friends.all #grab all friends
    @list_of_pending_friends ||= Array.new

    @all_friends.each do |person|
      if person.is_pending
        @list_of_pending_friends.push(person)
      end
    end

    #return the counter
    return @list_of_pending_friends
  end

  #helper for send_message
  def create_new_message(sender, message, date) #dunno how to place values into create? somehow pass in the key so the message can reference?    easier to parse thru whole message list instead of association? i dunno association
                                                #message = Message.create(:user, sender, message, date)
    self.messages.create(:message => message, :sender => sender, :date => date)
                                                #msg.save
  end

  #helper for create_new_message
  def create_new_friend(friend, state)

    #here will do error check if this works
    should_save = "true"
    self.friends.each { |person|
      if person.matches_my_name(friend)
        #matching name exit fun
        should_save = "false"
      end
    }

    if should_save == "true"
      self.friends.new(:friend => friend, :state => state)
      self.save
    end

  end
end
#rails generate scaffold user username:string password:string email:string geoX:string geoY:string status:string statuessage:string