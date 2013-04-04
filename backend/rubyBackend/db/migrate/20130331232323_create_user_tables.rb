class CreateUserTables < ActiveRecord::Migration
  def change
    create_table :user_tables do |t|
      t.string :user
      t.string :password
      t.string :email
      t.decimal :geoX
      t.decimal :geoY
      t.boolean :status
      t.string :statusMsg

      t.timestamps
    end
  end
end
