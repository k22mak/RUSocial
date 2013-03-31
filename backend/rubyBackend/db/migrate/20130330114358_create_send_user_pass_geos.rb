class CreateSendUserPassGeos < ActiveRecord::Migration
  def change
    create_table :send_user_pass_geos do |t|
      t.string :username
      t.string :password
      t.decimal :geoX
      t.decimal :geoY

      t.timestamps
    end
  end
end
