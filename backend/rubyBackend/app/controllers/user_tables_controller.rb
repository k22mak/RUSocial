class UserTablesController < ApplicationController
  # GET /user_tables
  # GET /user_tables.json
  def index
    #if params['user'] # We have 'action' & 'controller' by default

    #   @user_table = [UserTable.find(:first, :conditions => { :login => params['login'] })]

    #else
    # @persons = Person.find(:all)
    #end

    #@user_tables = UserTable.all

    if params[:user]
      @user_tables = UserTable.find(:first, :conditions => ['user = ?', params[:user]])
    else
      @user_tables = UserTable.all
    end

    respond_to do |format|
      format.html # index.html.erb
      format.json { render json: @user_tables }
    end
  end

  # GET /user_tables/1
  # GET /user_tables/1.json
  def show
    @user_table = UserTable.find(params[:id])

    respond_to do |format|
      format.html # show.html.erb
      format.json { render json: @user_table }
    end
  end

  # GET /user_tables/new
  # GET /user_tables/new.json
  def new
    @user_table = UserTable.new

    respond_to do |format|
      format.html # new.html.erb
      format.json { render json: @user_table }
    end
  end

  # GET /user_tables/1/edit
  def edit
    @user_table = UserTable.find(params[:id])
  end

  # POST /user_tables
  # POST /user_tables.json
  def create
    @user_table = UserTable.new(params[:user_table])

    respond_to do |format|
      if @user_table.save
        format.html { redirect_to @user_table, notice: 'User table was successfully created.' }
        format.json { render json: @user_table, status: :created, location: @user_table }
      else
        format.html { render action: "new" }
        format.json { render json: @user_table.errors, status: :unprocessable_entity }
      end
    end
  end

  # PUT /user_tables/1
  # PUT /user_tables/1.json
  def update
    @user_table = UserTable.find(params[:id])

    respond_to do |format|
      if @user_table.update_attributes(params[:user_table])
        format.html { redirect_to @user_table, notice: 'User table was successfully updated.' }
        format.json { head :no_content }
      else
        format.html { render action: "edit" }
        format.json { render json: @user_table.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /user_tables/1
  # DELETE /user_tables/1.json
  def destroy
    @user_table = UserTable.find(params[:id])
    @user_table.destroy

    respond_to do |format|
      format.html { redirect_to user_tables_url }
      format.json { head :no_content }
    end
  end
end
