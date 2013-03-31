class SendGeosController < ApplicationController
  # GET /send_geos
  # GET /send_geos.json
  def index
    @send_geos = SendGeo.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @send_geos }
    end
  end

  # GET /send_geos/1
  # GET /send_geos/1.json
  def show
    @send_geo = SendGeo.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @send_geo }
    end
  end

  # GET /send_geos/new
  # GET /send_geos/new.json
  def new
    @send_geo = SendGeo.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @send_geo }
    end
  end

  # GET /send_geos/1/edit
  def edit
    @send_geo = SendGeo.find(params[:id])
  end

  # POST /send_geos
  # POST /send_geos.json
  def create
    @send_geo = SendGeo.new(params[:send_geo])

    respond_to do |format|
      if @send_geo.save
        format.html { redirect_to @send_geo, notice: 'Send geo was successfully created.' }
        format.json { render json: @send_geo, status: :created, location: @send_geo }
      else
        format.html { render action: "new" }
        format.json { render json: @send_geo.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /send_geos/1
  # PUT /send_geos/1.json
  def update
    @send_geo = SendGeo.find(params[:id])

    respond_to do |format|
      if @send_geo.update_attributes(params[:send_geo])
        format.html { redirect_to @send_geo, notice: 'Send geo was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @send_geo.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /send_geos/1
  # DELETE /send_geos/1.json
  def destroy
    @send_geo = SendGeo.find(params[:id])
    @send_geo.destroy

    respond_to do |format|
      format.html { redirect_to send_geos_url }
      format.json { head :no_content }
    end
  end
end
