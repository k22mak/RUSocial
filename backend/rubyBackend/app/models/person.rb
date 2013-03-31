class Person < ActiveRecord::Base
  attr_accessible :geoX, :geoY, :lastModified, :messages, :password, :sessionStatus, :timeConnected, :username
end
