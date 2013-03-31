require 'test_helper'

class SendUsernameFindMessagesControllerTest < ActionController::TestCase
  setup do
    @send_username_find_message = send_username_find_messages(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:send_username_find_messages)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create send_username_find_message" do
    assert_difference('SendUsernameFindMessage.count') do
      post :create, send_username_find_message: { username: @send_username_find_message.username }
    end

    assert_redirected_to send_username_find_message_path(assigns(:send_username_find_message))
  end

  test "should show send_username_find_message" do
    get :show, id: @send_username_find_message
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @send_username_find_message
    assert_response :success
  end

  test "should update send_username_find_message" do
    put :update, id: @send_username_find_message, send_username_find_message: { username: @send_username_find_message.username }
    assert_redirected_to send_username_find_message_path(assigns(:send_username_find_message))
  end

  test "should destroy send_username_find_message" do
    assert_difference('SendUsernameFindMessage.count', -1) do
      delete :destroy, id: @send_username_find_message
    end

    assert_redirected_to send_username_find_messages_path
  end
end
