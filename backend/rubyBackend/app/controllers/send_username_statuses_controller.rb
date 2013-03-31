class SendUsernameStatusesController < ApplicationController
  # GET /send_username_statuses
  # GET /send_username_statuses.json
  def index
    @send_username_statuses = SendUsernameStatus.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @send_username_statuses }
    end
  end

  # GET /send_username_statuses/1
  # GET /send_username_statuses/1.json
  def show
    @send_username_status = SendUsernameStatus.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @send_username_status }
    end
  end

  # GET /send_username_statuses/new
  # GET /send_username_statuses/new.json
  def new
    @send_username_status = SendUsernameStatus.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @send_username_status }
    end
  end

  # GET /send_username_statuses/1/edit
  def edit
    @send_username_status = SendUsernameStatus.find(params[:id])
  end

  # POST /send_username_statuses
  # POST /send_username_statuses.json
  def create
    @send_username_status = SendUsernameStatus.new(params[:send_username_status])

    respond_to do |format|
      if @send_username_status.save
        format.html { redirect_to @send_username_status, notice: 'Send username status was successfully created.' }
        format.json { render json: @send_username_status, status: :created, location: @send_username_status }
      else
        format.html { render action: "new" }
        format.json { render json: @send_username_status.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /send_username_statuses/1
  # PUT /send_username_statuses/1.json
  def update
    @send_username_status = SendUsernameStatus.find(params[:id])

    respond_to do |format|
      if @send_username_status.update_attributes(params[:send_username_status])
        format.html { redirect_to @send_username_status, notice: 'Send username status was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @send_username_status.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /send_username_statuses/1
  # DELETE /send_username_statuses/1.json
  def destroy
    @send_username_status = SendUsernameStatus.find(params[:id])
    @send_username_status.destroy

    respond_to do |format|
      format.html { redirect_to send_username_statuses_url }
      format.json { head :no_content }
    end
  end
end
