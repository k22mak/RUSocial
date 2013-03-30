class CreateStudentInfos < ActiveRecord::Migration
  def change
    create_table :student_infos do |t|
      t.string :student
      t.decimal :xCoord
      t.decimal :yCoord
      t.boolean :sessionStatus
      t.timestamp :timeConnected
      t.timestamp :lastModified

      t.timestamps
    end
  end
end
