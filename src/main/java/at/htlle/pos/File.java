package at.htlle.pos;

public class File extends Node{
    /**
     * Properties
     */
    private String name;
    private long size;


    /*
     * Constructor
     */
    public File(String name, long size) {
        if (name == null) {
            throw new NullPointerException("cant be null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("cant be empty");
        }
        if (size < 0) {
            throw new IllegalArgumentException("cant be negative");
        }
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    @Override
    public int numberOfFiles() {
        return 1;
    }

    @Override
    public long getSize() {
        return size;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSize(long size) {
       this.size = size;
    }


    /*
     * Object methods
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + (int) (size ^ (size >>> 32));
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        File other = (File) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (size != other.size)
            return false;

        // is this true?
        // i dont know ._.
        return true;
        //fazit: ja es ist true

    }

    public String toString() {
        return name;
    }
}
