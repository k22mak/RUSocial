require 'test_helper'

class SendGeosControllerTest < ActionController::TestCase
  setup do
    @send_geo = send_geos(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:send_geos)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create send_geo" do
    assert_difference('SendGeo.count') do
      post :create, send_geo: { geoX: @send_geo.geoX, geoY: @send_geo.geoY }
    end

    assert_redirected_to send_geo_path(assigns(:send_geo))
  end

  test "should show send_geo" do
    get :show, id: @send_geo
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @send_geo
    assert_response :success
  end

  test "should update send_geo" do
    put :update, id: @send_geo, send_geo: { geoX: @send_geo.geoX, geoY: @send_geo.geoY }
    assert_redirected_to send_geo_path(assigns(:send_geo))
  end

  test "should destroy send_geo" do
    assert_difference('SendGeo.count', -1) do
      delete :destroy, id: @send_geo
    end

    assert_redirected_to send_geos_path
  end
end
