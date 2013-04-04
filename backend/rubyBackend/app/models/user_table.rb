class UserTable < ActiveRecord::Base
  attr_accessible :email, :geoX, :geoY, :password, :status, :statusMsg, :user
end
