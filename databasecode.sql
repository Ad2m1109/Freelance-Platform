CREATE database IF NOT EXISTS freelance_platform;
-- Main Users Table
CREATE TABLE users (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    user_type ENUM('FREELANCER', 'CLIENT') NOT NULL,
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    last_login DATETIME,
    is_active BOOLEAN DEFAULT TRUE
) ENGINE=InnoDB;

-- User Profiles (without image)
CREATE TABLE profiles (
    profile_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT UNIQUE NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    bio TEXT,
    company_name VARCHAR(100),
    hourly_rate DECIMAL(10,2),
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Skills Catalog
CREATE TABLE skills (
    skill_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) UNIQUE NOT NULL,
    category VARCHAR(50) NOT NULL
) ENGINE=InnoDB;

-- Freelancer Skills
CREATE TABLE freelancer_skills (
    freelancer_id BIGINT NOT NULL,
    skill_id INT NOT NULL,
    level ENUM('BEGINNER', 'INTERMEDIATE', 'ADVANCED', 'EXPERT') NOT NULL,
    PRIMARY KEY (freelancer_id, skill_id),
    FOREIGN KEY (freelancer_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (skill_id) REFERENCES skills(skill_id)
) ENGINE=InnoDB;

-- Job Posts
CREATE TABLE jobs (
    job_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    client_id BIGINT NOT NULL,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    budget DECIMAL(10,2),
    posted_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    deadline DATE,
    status ENUM('OPEN', 'ASSIGNED', 'COMPLETED', 'CANCELLED') DEFAULT 'OPEN',
    FOREIGN KEY (client_id) REFERENCES users(user_id)
) ENGINE=InnoDB;

-- Job Required Skills
CREATE TABLE job_skills (
    job_id BIGINT NOT NULL,
    skill_id INT NOT NULL,
    PRIMARY KEY (job_id, skill_id),
    FOREIGN KEY (job_id) REFERENCES jobs(job_id) ON DELETE CASCADE,
    FOREIGN KEY (skill_id) REFERENCES skills(skill_id)
) ENGINE=InnoDB;

-- Job Proposals
CREATE TABLE proposals (
    proposal_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    job_id BIGINT NOT NULL,
    freelancer_id BIGINT NOT NULL,
    cover_letter TEXT NOT NULL,
    bid_amount DECIMAL(10,2),
    status ENUM('PENDING', 'ACCEPTED', 'REJECTED') DEFAULT 'PENDING',
    submitted_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (job_id) REFERENCES jobs(job_id),
    FOREIGN KEY (freelancer_id) REFERENCES users(user_id),
    UNIQUE (job_id, freelancer_id) -- Prevent duplicate proposals
) ENGINE=InnoDB;

-- Reviews System
CREATE TABLE reviews (
    review_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    job_id BIGINT NOT NULL,
    reviewer_id BIGINT NOT NULL,
    reviewee_id BIGINT NOT NULL,
    rating TINYINT NOT NULL CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (job_id) REFERENCES jobs(job_id),
    FOREIGN KEY (reviewer_id) REFERENCES users(user_id),
    FOREIGN KEY (reviewee_id) REFERENCES users(user_id)
) ENGINE=InnoDB;

-- Messaging System
CREATE TABLE messages (
    message_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sender_id BIGINT NOT NULL,
    receiver_id BIGINT NOT NULL,
    job_id BIGINT,
    content TEXT NOT NULL,
    sent_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    is_read BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (sender_id) REFERENCES users(user_id),
    FOREIGN KEY (receiver_id) REFERENCES users(user_id),
    FOREIGN KEY (job_id) REFERENCES jobs(job_id)
) ENGINE=InnoDB;

-- Indexes for Performance
CREATE INDEX idx_user_type ON users(user_type);
CREATE INDEX idx_job_status ON jobs(status);
CREATE INDEX idx_proposal_status ON proposals(status);
CREATE INDEX idx_freelancer_skills ON freelancer_skills(skill_id);
CREATE INDEX idx_job_client ON jobs(client_id);
CREATE INDEX idx_proposal_job ON proposals(job_id);
CREATE INDEX idx_proposal_freelancer ON proposals(freelancer_id);
CREATE INDEX idx_review_reviewee ON reviews(reviewee_id);