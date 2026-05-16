# Database Schema

## Tables

---

# users

| Column | Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| email | VARCHAR | User email |
| password | VARCHAR | Encoded password |
| role | VARCHAR | USER / ADMIN |

---

# time_entry

| Column | Type | Description |
|---|---|---|
| id | BIGINT | Primary key |
| description | VARCHAR | Task description |
| start_time | TIMESTAMP | Start time |
| end_time | TIMESTAMP | End time |
| hours_spent | INTEGER | Hours spent |

---

## Relationships

- One user can create many time entries
- Role-based authorization using Spring Security

---

## Technologies

- PostgreSQL
- Hibernate JPA
- Spring Data JPA