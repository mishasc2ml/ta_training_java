package com.epam.rd.contactbook;

public class Contact {
    public String contactName;
    private final int emailEntries = 3;
    private int currentEmailEntries;
    private final int socialsEntries = 5;
    private int currentSocialsEntries;
    private final ContactInfo[] emailInfo;
    private final ContactInfo[] socialsInfo;
    private ContactInfo nameInfo;
    private ContactInfo telephoneInfo;
    private int globalCounter;

    public Contact(String contactName) {
        nameInfo = new NameContactInfo(contactName);
        globalCounter++;
        emailInfo = new ContactInfo[emailEntries];
        socialsInfo = new ContactInfo[socialsEntries];
    }

    public void rename(String newName) {
        if (newName != null && !newName.isEmpty()) {
            nameInfo = new NameContactInfo(newName);
        }
    }

    public Email addEmail(String localPart, String domain) {
        if (currentEmailEntries < emailEntries) {
            Email email = new Email(localPart, domain);
            emailInfo[currentEmailEntries++] = email;
            globalCounter++;
            return email;
        } else return null;
    }


    public Email addEpamEmail(String firstname, String lastname) {
        if (currentEmailEntries < emailEntries) {
            Email email = new Email(firstname + "_" + lastname, "epam.com") {
                @Override
                public String getTitle() {
                    return "Epam Email";
                }
            };
            emailInfo[currentEmailEntries++] = email;
            globalCounter++;
            return email;
        } else return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if (telephoneInfo == null) {
            telephoneInfo = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }
            };
            globalCounter++;
            return telephoneInfo;
        } else return null;
    }

    public Social addTwitter(String twitterId) {
        return addSocialMedia("Twitter", twitterId);
    }

    public Social addInstagram(String instagramId) {
        return addSocialMedia("Instagram", instagramId);
    }

    public Social addSocialMedia(String title, String id) {
        if (currentSocialsEntries < socialsEntries) {
            Social social = new Social(title, id) {
                @Override
                public String getTitle() {
                    return title;
                }

                @Override
                public String getValue() {
                    return id;
                }
            };
            socialsInfo[currentSocialsEntries++] = social;
            globalCounter++;
            return social;
        } else return null;
    }

    public ContactInfo[] getInfo() {
        int localCounter = 0;
        ContactInfo[] info = new ContactInfo[globalCounter];
        info[localCounter++] = nameInfo;
        if (telephoneInfo != null) {
            info[localCounter++] = telephoneInfo;
        }
        if (emailInfo != null) {
            for (int i = 0; i < currentEmailEntries; i++) {
                info[localCounter++] = emailInfo[i];
            }
        }
        if (socialsInfo != null) {
            for (int i = 0; i < currentSocialsEntries; i++) {
                info[localCounter++] = socialsInfo[i];
            }
        }
        return info;
    }

    private class NameContactInfo implements ContactInfo {
        public NameContactInfo(String contactName) {
            Contact.this.contactName = contactName;
        }

        @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return contactName;
        }
    }

    public static class Email implements ContactInfo {
        private final String localPart;
        private final String domain;

        public Email(String localPart, String domain) {
            this.localPart = localPart;
            this.domain = domain;
        }

        @Override
        public String getTitle() {
            return "Email";
        }

        @Override
        public String getValue() {
            return localPart + "@" + domain;
        }
    }

    public static class Social implements ContactInfo {
        private final String title;
        private final String id;

        public Social(String title, String id) {
            this.title = title;
            this.id = id;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return id;
        }
    }

}
