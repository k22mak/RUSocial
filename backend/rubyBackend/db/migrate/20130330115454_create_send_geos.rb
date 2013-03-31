class CreateSendGeos < ActiveRecord::Migration
  def change
    create_table :send_geos do |t|
      t.decimal :geoX
      t.decimal :geoY

      t.timestamps
    end
  end
end
