package edu.cmu.DirManager;

public class Manager {
    private DirOps dirOps;

    /**
     * Creates a new directory at the specified path.
     *
     * @param path the path where the new directory should be created
     * @return  0 if the directory creation was successful,
     *         -1 if the directory already exists,
     *         -2 if the path is invalid,
     *         -3 if the directory operations object (dirOps) is not initialized
     */
    public int newDirectory(String path) {
        if (dirOps == null) {
            throw new IllegalArgumentException("Cannot find DirOps Object");
        }

        if (dirOps.checkDirectoryExists(path)) {
            throw new IllegalArgumentException("Dir Already Exist");
        } else if (!dirOps.checkPathValid(path)) {
            throw new IllegalArgumentException("Invalid Path");
        } else {
            dirOps.createDirectory(path); // Create the directory
            return 1; // Success
        }
    }
}
