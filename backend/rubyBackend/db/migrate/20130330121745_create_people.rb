class CreatePeople < ActiveRecord::Migration
  def change
    create_table :people do |t|
      t.string :username
      t.string :password
      t.decimal :geoX
      t.decimal :geoY
      t.boolean :sessionStatus
      t.text :messages
      t.timestamp :timeConnected
      t.timestamp :lastModified

      t.timestamps
    end
  end
end
