class StudentInfosController < ApplicationController
  # GET /student_infos
  # GET /student_infos.json
  def index
    @student_infos = StudentInfo.all

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @student_infos }
    end
  end

  # GET /student_infos/1
  # GET /student_infos/1.json
  def show
    @student_info = StudentInfo.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @student_info }
    end
  end

  # GET /student_infos/new
  # GET /student_infos/new.json
  def new
    @student_info = StudentInfo.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @student_info }
    end
  end

  # GET /student_infos/1/edit
  def edit
    @student_info = StudentInfo.find(params[:id])
  end

  # POST /student_infos
  # POST /student_infos.json
  def create
    @student_info = StudentInfo.new(params[:student_info])

    respond_to do |format|
      if @student_info.save
        format.html { redirect_to @student_info, notice: 'Student info was successfully created.' }
        format.json { render json: @student_info, status: :created, location: @student_info }
      else
        format.html { render action: "new" }
        format.json { render json: @student_info.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /student_infos/1
  # PUT /student_infos/1.json
  def update
    @student_info = StudentInfo.find(params[:id])

    respond_to do |format|
      if @student_info.update_attributes(params[:student_info])
        format.html { redirect_to @student_info, notice: 'Student info was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @student_info.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /student_infos/1
  # DELETE /student_infos/1.json
  def destroy
    @student_info = StudentInfo.find(params[:id])
    @student_info.destroy

    respond_to do |format|
      format.html { redirect_to student_infos_url }
      format.json { head :no_content }
    end
  end
end
