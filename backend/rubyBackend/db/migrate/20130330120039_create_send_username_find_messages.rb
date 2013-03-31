class CreateSendUsernameFindMessages < ActiveRecord::Migration
  def change
    create_table :send_username_find_messages do |t|
      t.string :username

      t.timestamps
    end
  end
end
