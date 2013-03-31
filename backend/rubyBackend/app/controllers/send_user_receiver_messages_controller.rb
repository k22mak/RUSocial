class SendUserReceiverMessagesController < ApplicationController
  # GET /send_user_receiver_messages
  # GET /send_user_receiver_messages.json
  def index
    @send_user_receiver_messages = SendUserReceiverMessage.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @send_user_receiver_messages }
    end
  end

  # GET /send_user_receiver_messages/1
  # GET /send_user_receiver_messages/1.json
  def show
    @send_user_receiver_message = SendUserReceiverMessage.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @send_user_receiver_message }
    end
  end

  # GET /send_user_receiver_messages/new
  # GET /send_user_receiver_messages/new.json
  def new
    @send_user_receiver_message = SendUserReceiverMessage.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @send_user_receiver_message }
    end
  end

  # GET /send_user_receiver_messages/1/edit
  def edit
    @send_user_receiver_message = SendUserReceiverMessage.find(params[:id])
  end

  # POST /send_user_receiver_messages
  # POST /send_user_receiver_messages.json
  def create
    @send_user_receiver_message = SendUserReceiverMessage.new(params[:send_user_receiver_message])

    respond_to do |format|
      if @send_user_receiver_message.save
        format.html { redirect_to @send_user_receiver_message, notice: 'Send user receiver message was successfully created.' }
        format.json { render json: @send_user_receiver_message, status: :created, location: @send_user_receiver_message }
      else
        format.html { render action: "new" }
        format.json { render json: @send_user_receiver_message.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /send_user_receiver_messages/1
  # PUT /send_user_receiver_messages/1.json
  def update
    @send_user_receiver_message = SendUserReceiverMessage.find(params[:id])

    respond_to do |format|
      if @send_user_receiver_message.update_attributes(params[:send_user_receiver_message])
        format.html { redirect_to @send_user_receiver_message, notice: 'Send user receiver message was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @send_user_receiver_message.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /send_user_receiver_messages/1
  # DELETE /send_user_receiver_messages/1.json
  def destroy
    @send_user_receiver_message = SendUserReceiverMessage.find(params[:id])
    @send_user_receiver_message.destroy

    respond_to do |format|
      format.html { redirect_to send_user_receiver_messages_url }
      format.json { head :no_content }
    end
  end
end
