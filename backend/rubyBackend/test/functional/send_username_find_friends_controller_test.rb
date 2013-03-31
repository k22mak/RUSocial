require 'test_helper'

class SendUsernameFindFriendsControllerTest < ActionController::TestCase
  setup do
    @send_username_find_friend = send_username_find_friends(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:send_username_find_friends)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create send_username_find_friend" do
    assert_difference('SendUsernameFindFriend.count') do
      post :create, send_username_find_friend: { username: @send_username_find_friend.username }
    end

    assert_redirected_to send_username_find_friend_path(assigns(:send_username_find_friend))
  end

  test "should show send_username_find_friend" do
    get :show, id: @send_username_find_friend
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @send_username_find_friend
    assert_response :success
  end

  test "should update send_username_find_friend" do
    put :update, id: @send_username_find_friend, send_username_find_friend: { username: @send_username_find_friend.username }
    assert_redirected_to send_username_find_friend_path(assigns(:send_username_find_friend))
  end

  test "should destroy send_username_find_friend" do
    assert_difference('SendUsernameFindFriend.count', -1) do
      delete :destroy, id: @send_username_find_friend
    end

    assert_redirected_to send_username_find_friends_path
  end
end
