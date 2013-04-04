class CreateFriends < ActiveRecord::Migration
  def change
    create_table :friends do |t|
      t.string :friend
      t.string :state

      t.timestamps
    end
  end
end
