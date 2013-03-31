class CreateSendUserReceiverMessages < ActiveRecord::Migration
  def change
    create_table :send_user_receiver_messages do |t|
      t.string :username
      t.string :receiver
      t.text :message

      t.timestamps
    end
  end
end
