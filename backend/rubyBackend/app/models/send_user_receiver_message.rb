class SendUserReceiverMessage < ActiveRecord::Base
  attr_accessible :message, :receiver, :username
end
