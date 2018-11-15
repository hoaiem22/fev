package fev.management.dto;

public class AccountCast {
    
    private Integer id;
    private String username;
    private String password;
    private String role;
    private String note;
    public AccountCast(Integer id, String username, String password, String role, String note) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.note = note;
    }
    public AccountCast(Integer id, String username, String role, String note) {
        super();
        this.id = id;
        this.username = username;
        this.role = role;
        this.note = note;
    }
    /**
    * Get value of id.
    * @return the id
    */
    public Integer getId() {
        return id;
    }
    /**
     * Set the value for id.
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
    * Get value of username.
    * @return the username
    */
    public String getUsername() {
        return username;
    }
    /**
     * Set the value for username.
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
    * Get value of password.
    * @return the password
    */
    public String getPassword() {
        return password;
    }
    /**
     * Set the value for password.
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
    * Get value of role.
    * @return the role
    */
    public String getRole() {
        return role;
    }
    /**
     * Set the value for role.
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }
    /**
    * Get value of note.
    * @return the note
    */
    public String getNote() {
        return note;
    }
    /**
     * Set the value for note.
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    
    
}
