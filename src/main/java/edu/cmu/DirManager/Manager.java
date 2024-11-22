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
            return -3; // dirOps is not initialized
        }

        if (dirOps.checkDirectoryExists(path)) {
            return -1; // Directory already exists
        } else if (!dirOps.checkPathValid(path)) {
            return -2; // Invalid path
        } else {
            dirOps.createDirectory(path); // Create the directory
            return 0; // Success
        }
    }
}
