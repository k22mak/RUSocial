require 'test_helper'

class UserTablesControllerTest < ActionController::TestCase
  setup do
    @user_table = user_tables(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:user_tables)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create user_table" do
    assert_difference('UserTable.count') do
      post :create, user_table: { email: @user_table.email, geoX: @user_table.geoX, geoY: @user_table.geoY, password: @user_table.password, status: @user_table.status, statusMsg: @user_table.statusMsg, user: @user_table.user }
    end

    assert_redirected_to user_table_path(assigns(:user_table))
  end

  test "should show user_table" do
    get :show, id: @user_table
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @user_table
    assert_response :success
  end

  test "should update user_table" do
    put :update, id: @user_table, user_table: { email: @user_table.email, geoX: @user_table.geoX, geoY: @user_table.geoY, password: @user_table.password, status: @user_table.status, statusMsg: @user_table.statusMsg, user: @user_table.user }
    assert_redirected_to user_table_path(assigns(:user_table))
  end

  test "should destroy user_table" do
    assert_difference('UserTable.count', -1) do
      delete :destroy, id: @user_table
    end

    assert_redirected_to user_tables_path
  end
end
