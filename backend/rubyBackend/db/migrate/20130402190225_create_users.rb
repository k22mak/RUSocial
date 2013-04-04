class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :username
      t.string :password
      t.string :email
      t.string :geoX
      t.string :geoY
      t.string :status
      t.string :status_message

      t.timestamps
    end
  end
end
