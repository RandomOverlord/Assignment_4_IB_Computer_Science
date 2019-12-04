package sample;

import javafx.beans.property.SimpleIntegerProperty;

public class TableData {
    private SimpleIntegerProperty ID;
    private SimpleIntegerProperty Seq;
    private SimpleIntegerProperty Bin;

    public TableData(Integer ID, Integer Seq, Integer Bin) {
        this.ID = new SimpleIntegerProperty(ID);
        this.Seq = new SimpleIntegerProperty(Seq);
        this.Bin = new SimpleIntegerProperty(Bin);
    }
        public int getID() {
            return ID.get();
        }

        public void setID(int ID) {
            this.ID = new SimpleIntegerProperty(ID);
        }

        public Integer getSeq() {
            return Seq.get();
        }

        public void setSeq(Integer Seq) {
            this.Seq = new SimpleIntegerProperty(Seq);
        }

        public Integer getBin() {
            return Bin.get();
        }

        public void setBin(Integer Bin) {
            this.Bin = new SimpleIntegerProperty(Bin);
        }
    }