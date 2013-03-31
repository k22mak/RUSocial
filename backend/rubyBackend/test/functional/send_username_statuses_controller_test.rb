require 'test_helper'

class SendUsernameStatusesControllerTest < ActionController::TestCase
  setup do
    @send_username_status = send_username_statuses(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:send_username_statuses)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create send_username_status" do
    assert_difference('SendUsernameStatus.count') do
      post :create, send_username_status: { status: @send_username_status.status, username: @send_username_status.username }
    end

    assert_redirected_to send_username_status_path(assigns(:send_username_status))
  end

  test "should show send_username_status" do
    get :show, id: @send_username_status
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @send_username_status
    assert_response :success
  end

  test "should update send_username_status" do
    put :update, id: @send_username_status, send_username_status: { status: @send_username_status.status, username: @send_username_status.username }
    assert_redirected_to send_username_status_path(assigns(:send_username_status))
  end

  test "should destroy send_username_status" do
    assert_difference('SendUsernameStatus.count', -1) do
      delete :destroy, id: @send_username_status
    end

    assert_redirected_to send_username_statuses_path
  end
end
