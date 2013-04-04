class CreateMessages < ActiveRecord::Migration
  def change
    create_table :messages do |t|
      t.string :sender
      t.text :message
      t.string :date

      t.timestamps
    end
  end
end
