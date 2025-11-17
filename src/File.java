public class File {

    private String fileName;
    private String fileType;

    public File(String fileName, String fileType) {
        setFileName(fileName);
        setFileType(fileType);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be empty");
        }
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        if (fileType == null || fileType.trim().isEmpty()) {
            throw new IllegalArgumentException("File type cannot be empty");
        }
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "File{name='" + fileName + "', type='" + fileType + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof File)) return false;
        File other = (File) obj;
        return this.fileName.equals(other.fileName) &&
               this.fileType.equals(other.fileType);
    }
}