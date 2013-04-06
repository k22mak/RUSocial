class Friend < ActiveRecord::Base
  attr_accessible :friend, :state
  belongs_to :user

  def is_online
    if self.state.upcase == "online".upcase
      return true
    else
      return false
    end
  end

  def is_pending
    if self.state.upcase == "pending".upcase
      return true
    else
      return false
    end
  end

  def matches_my_name(person)
    if self.friend == person
      return true
    else
      return false
    end
  end

  def get_state
    return self.state
  end



end
