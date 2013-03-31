class SendUsernameFindFriendsController < ApplicationController
  # GET /send_username_find_friends
  # GET /send_username_find_friends.json
  def index
    @send_username_find_friends = SendUsernameFindFriend.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @send_username_find_friends }
    end
  end

  # GET /send_username_find_friends/1
  # GET /send_username_find_friends/1.json
  def show
    @send_username_find_friend = SendUsernameFindFriend.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @send_username_find_friend }
    end
  end

  # GET /send_username_find_friends/new
  # GET /send_username_find_friends/new.json
  def new
    @send_username_find_friend = SendUsernameFindFriend.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @send_username_find_friend }
    end
  end

  # GET /send_username_find_friends/1/edit
  def edit
    @send_username_find_friend = SendUsernameFindFriend.find(params[:id])
  end

  # POST /send_username_find_friends
  # POST /send_username_find_friends.json
  def create
    @send_username_find_friend = SendUsernameFindFriend.new(params[:send_username_find_friend])

    respond_to do |format|
      if @send_username_find_friend.save
        format.html { redirect_to @send_username_find_friend, notice: 'Send username find friend was successfully created.' }
        format.json { render json: @send_username_find_friend, status: :created, location: @send_username_find_friend }
      else
        format.html { render action: "new" }
        format.json { render json: @send_username_find_friend.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /send_username_find_friends/1
  # PUT /send_username_find_friends/1.json
  def update
    @send_username_find_friend = SendUsernameFindFriend.find(params[:id])

    respond_to do |format|
      if @send_username_find_friend.update_attributes(params[:send_username_find_friend])
        format.html { redirect_to @send_username_find_friend, notice: 'Send username find friend was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @send_username_find_friend.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /send_username_find_friends/1
  # DELETE /send_username_find_friends/1.json
  def destroy
    @send_username_find_friend = SendUsernameFindFriend.find(params[:id])
    @send_username_find_friend.destroy

    respond_to do |format|
      format.html { redirect_to send_username_find_friends_url }
      format.json { head :no_content }
    end
  end
end
