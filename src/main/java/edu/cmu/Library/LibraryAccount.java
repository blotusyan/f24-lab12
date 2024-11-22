package edu.cmu.Library;

public class LibraryAccount {
    private LibraryService libraryService;

    /**
     * Retrieves an array of checked out books associated with the specified user ID. If the user
     * has no books checked out, the returned list will be empty. Since multiple households may
     * share a single account, the user ID is of the form "libraryID:userName".
     * e.g., "12345:John Doe"
     *
     * @param userId the ID of the user whose books are to be retrieved
     * @return an array of Book objects the user has checked out
     */
    public Book[] getBooks(String userId) {
        // Validate the input
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        // Split the userId and validate the parts
        String[] parts = userId.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("User ID must be in the format 'libraryID:userName'");
        }

        String id = parts[0];    // Library ID
        String name = parts[1];  // User Name

        // Retrieve books using libraryService
        return libraryService.getBooks(name, id);
    }

}
