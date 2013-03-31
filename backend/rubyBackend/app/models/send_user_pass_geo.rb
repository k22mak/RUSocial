class SendUserPassGeo < ActiveRecord::Base
  attr_accessible :geoX, :geoY, :password, :username
end
