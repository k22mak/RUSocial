class SendUserPassGeosController < ApplicationController
  # GET /send_user_pass_geos
  # GET /send_user_pass_geos.json
  def index
    @send_user_pass_geos = SendUserPassGeo.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @send_user_pass_geos }
    end
  end

  # GET /send_user_pass_geos/1
  # GET /send_user_pass_geos/1.json
  def show
    @send_user_pass_geo = SendUserPassGeo.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @send_user_pass_geo }
    end
  end

  # GET /send_user_pass_geos/new
  # GET /send_user_pass_geos/new.json
  def new
    @send_user_pass_geo = SendUserPassGeo.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @send_user_pass_geo }
    end
  end

  # GET /send_user_pass_geos/1/edit
  def edit
    @send_user_pass_geo = SendUserPassGeo.find(params[:id])
  end

  # POST /send_user_pass_geos
  # POST /send_user_pass_geos.json
  def create
    @send_user_pass_geo = SendUserPassGeo.new(params[:send_user_pass_geo])

    respond_to do |format|
      if @send_user_pass_geo.save
        format.html { redirect_to @send_user_pass_geo, notice: 'Send user pass geo was successfully created.' }
        format.json { render json: @send_user_pass_geo, status: :created, location: @send_user_pass_geo }
      else
        format.html { render action: "new" }
        format.json { render json: @send_user_pass_geo.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /send_user_pass_geos/1
  # PUT /send_user_pass_geos/1.json
  def update
    @send_user_pass_geo = SendUserPassGeo.find(params[:id])

    respond_to do |format|
      if @send_user_pass_geo.update_attributes(params[:send_user_pass_geo])
        format.html { redirect_to @send_user_pass_geo, notice: 'Send user pass geo was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @send_user_pass_geo.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /send_user_pass_geos/1
  # DELETE /send_user_pass_geos/1.json
  def destroy
    @send_user_pass_geo = SendUserPassGeo.find(params[:id])
    @send_user_pass_geo.destroy

    respond_to do |format|
      format.html { redirect_to send_user_pass_geos_url }
      format.json { head :no_content }
    end
  end
end
