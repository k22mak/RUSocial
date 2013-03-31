class CreateSendUsernameStatuses < ActiveRecord::Migration
  def change
    create_table :send_username_statuses do |t|
      t.string :username
      t.boolean :status

      t.timestamps
    end
  end
end
