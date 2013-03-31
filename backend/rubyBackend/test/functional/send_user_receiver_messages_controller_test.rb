require 'test_helper'

class SendUserReceiverMessagesControllerTest < ActionController::TestCase
  setup do
    @send_user_receiver_message = send_user_receiver_messages(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:send_user_receiver_messages)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create send_user_receiver_message" do
    assert_difference('SendUserReceiverMessage.count') do
      post :create, send_user_receiver_message: { message: @send_user_receiver_message.message, receiver: @send_user_receiver_message.receiver, username: @send_user_receiver_message.username }
    end

    assert_redirected_to send_user_receiver_message_path(assigns(:send_user_receiver_message))
  end

  test "should show send_user_receiver_message" do
    get :show, id: @send_user_receiver_message
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @send_user_receiver_message
    assert_response :success
  end

  test "should update send_user_receiver_message" do
    put :update, id: @send_user_receiver_message, send_user_receiver_message: { message: @send_user_receiver_message.message, receiver: @send_user_receiver_message.receiver, username: @send_user_receiver_message.username }
    assert_redirected_to send_user_receiver_message_path(assigns(:send_user_receiver_message))
  end

  test "should destroy send_user_receiver_message" do
    assert_difference('SendUserReceiverMessage.count', -1) do
      delete :destroy, id: @send_user_receiver_message
    end

    assert_redirected_to send_user_receiver_messages_path
  end
end
