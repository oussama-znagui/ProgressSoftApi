ProgressSoft FX Deals Import API

This project is a Spring Boot REST API developed as part of the ProgressSoft Java Developer assignment.
The system receives FX deal records, validates them, and stores them in a database while preventing duplicate imports.

🚀 Project Overview

This API is responsible for:

Accepting FX deal details through a POST endpoint

Validating incoming data (ISO currency codes, missing fields, types, timestamps, etc.)

Ensuring that each deal is stored exactly once

Persisting validated deals permanently (no rollback allowed)

Logging all operations

Providing meaningful error handling

Supporting Docker deployment

Offering unit tests with significant coverage


🧩 API Endpoints
POST /deals

Create a new FX deal.

Request Body
{
"dealId": "DL-20240215-001",
"fromCurrency": "USD",
"toCurrency": "EUR",
"amount": 1500.75
}

Responses
Status	Description
200 OK	Deal imported successfully
400 Bad Request	Validation error (missing field, invalid ISO code, etc.)

**Validations Implemented**

Required fields

Valid ISO  currency codes


Numeric amount validation

Duplicate deal detection using deal ID

Custom exceptions with structured error responses



**Logging**

The system includes:

Info logs for successful deal imports

Warning logs for duplicates

Error logs for validation failures

Detailed logs for debugging (trace-level optional)

Logs follow Spring Boot’s SLF4J + Logback standard.



**Docker Deployment**

2️⃣ Start the API + PostgreSQL
docker-compose up --build

3️⃣ API URL
http://localhost:8080/deals


docker:
docker-compose up --build

How to Run Locally
git clone https://github.com/oussama-znagui/ProgressSoftApi.git
cd ProgressSoftApi
docker-compose up --build


Author
Oussama ZNAGUI
Java Developer
GitHub: https://github.com/oussama-znagui