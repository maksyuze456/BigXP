package org.bigxp.bigxp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

    @Entity
    public class LogInd {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int LogIndId;

        private String username;

        private String password;

        public int getLogIndId() {
            return LogIndId;
        }

        public void setLogIndId(int logIndId) {
            LogIndId = logIndId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
