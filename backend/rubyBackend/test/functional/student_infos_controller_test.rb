require 'test_helper'

class StudentInfosControllerTest < ActionController::TestCase
  setup do
    @student_info = student_infos(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:student_infos)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create student_info" do
    assert_difference('StudentInfo.count') do
      post :create, student_info: @student_info.attributes
    end

    assert_redirected_to student_info_path(assigns(:student_info))
  end

  test "should show student_info" do
    get :show, id: @student_info
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @student_info
    assert_response :success
  end

  test "should update student_info" do
    put :update, id: @student_info, student_info: @student_info.attributes
    assert_redirected_to student_info_path(assigns(:student_info))
  end

  test "should destroy student_info" do
    assert_difference('StudentInfo.count', -1) do
      delete :destroy, id: @student_info
    end

    assert_redirected_to student_infos_path
  end
end
