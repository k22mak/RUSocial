class SendUsernameFindMessagesController < ApplicationController
  # GET /send_username_find_messages
  # GET /send_username_find_messages.json
  def index
    @send_username_find_messages = SendUsernameFindMessage.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @send_username_find_messages }
    end
  end

  # GET /send_username_find_messages/1
  # GET /send_username_find_messages/1.json
  def show
    @send_username_find_message = SendUsernameFindMessage.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @send_username_find_message }
    end
  end

  # GET /send_username_find_messages/new
  # GET /send_username_find_messages/new.json
  def new
    @send_username_find_message = SendUsernameFindMessage.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @send_username_find_message }
    end
  end

  # GET /send_username_find_messages/1/edit
  def edit
    @send_username_find_message = SendUsernameFindMessage.find(params[:id])
  end

  # POST /send_username_find_messages
  # POST /send_username_find_messages.json
  def create
    @send_username_find_message = SendUsernameFindMessage.new(params[:send_username_find_message])

    respond_to do |format|
      if @send_username_find_message.save
        format.html { redirect_to @send_username_find_message, notice: 'Send username find message was successfully created.' }
        format.json { render json: @send_username_find_message, status: :created, location: @send_username_find_message }
      else
        format.html { render action: "new" }
        format.json { render json: @send_username_find_message.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /send_username_find_messages/1
  # PUT /send_username_find_messages/1.json
  def update
    @send_username_find_message = SendUsernameFindMessage.find(params[:id])

    respond_to do |format|
      if @send_username_find_message.update_attributes(params[:send_username_find_message])
        format.html { redirect_to @send_username_find_message, notice: 'Send username find message was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @send_username_find_message.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /send_username_find_messages/1
  # DELETE /send_username_find_messages/1.json
  def destroy
    @send_username_find_message = SendUsernameFindMessage.find(params[:id])
    @send_username_find_message.destroy

    respond_to do |format|
      format.html { redirect_to send_username_find_messages_url }
      format.json { head :no_content }
    end
  end
end
