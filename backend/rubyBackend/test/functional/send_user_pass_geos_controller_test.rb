require 'test_helper'

class SendUserPassGeosControllerTest < ActionController::TestCase
  setup do
    @send_user_pass_geo = send_user_pass_geos(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:send_user_pass_geos)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create send_user_pass_geo" do
    assert_difference('SendUserPassGeo.count') do
      post :create, send_user_pass_geo: { geoX: @send_user_pass_geo.geoX, geoY: @send_user_pass_geo.geoY, password: @send_user_pass_geo.password, username: @send_user_pass_geo.username }
    end

    assert_redirected_to send_user_pass_geo_path(assigns(:send_user_pass_geo))
  end

  test "should show send_user_pass_geo" do
    get :show, id: @send_user_pass_geo
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @send_user_pass_geo
    assert_response :success
  end

  test "should update send_user_pass_geo" do
    put :update, id: @send_user_pass_geo, send_user_pass_geo: { geoX: @send_user_pass_geo.geoX, geoY: @send_user_pass_geo.geoY, password: @send_user_pass_geo.password, username: @send_user_pass_geo.username }
    assert_redirected_to send_user_pass_geo_path(assigns(:send_user_pass_geo))
  end

  test "should destroy send_user_pass_geo" do
    assert_difference('SendUserPassGeo.count', -1) do
      delete :destroy, id: @send_user_pass_geo
    end

    assert_redirected_to send_user_pass_geos_path
  end
end
