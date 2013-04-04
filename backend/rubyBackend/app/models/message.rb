class Message < ActiveRecord::Base
  attr_accessible :date, :message, :sender
  belongs_to :user
end