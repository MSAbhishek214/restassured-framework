# Rest Assured Modular API Test Framework (v1)

## Overview
This is a modular, DI‑enabled API test framework built with:
- **Java + Maven**
- **Rest Assured** for HTTP calls
- **Cucumber (BDD)** for scenario definition
- **JUnit Platform** for execution
- **PicoContainer** for scenario‑scoped dependency injection

It’s designed for clarity, maintainability, and interview‑ready architecture:
- **Tier 1:** Stateless, independent CRUD feature files (`AddPlace.feature`, `UpdatePlace.feature`, etc.)
- **Tier 2:** An intentional state‑sharing `.feature` for full end‑to‑end lifecycle coverage (`PlaceLifeCycle.feature`)

---

## Key Features
- **Scenario‑Scoped State** via `CommonSteps` — no statics required
- **Reusable Step Classes** split by API domain (`AddPlaceSteps`, `GetPlaceSteps`, etc.)
- **PayloadBuilder** for clean request body creation
- **Spec Builder Ready** — slot in custom request/response specifications easily
- **Individual Runners** for each .feature + dedicated E2E runner

---

## Running Tests
Tagged scenarios:
mvn test -Dcucumber.filter.tags="@PlaceLifeCycle"

Example E2E Flow (PlaceLifeCycle.feature)
- Add Place — Creates a new place, stores place_id
- Get Place — Retrieves details by place_id
- Update Place — Changes address for the same place_id
- Delete Place — Removes the place
- Verify Deletion — Confirms place_id no longer exists

Version History
v1 — Initial working build with:
- PicoContainer DI for state sharing
- Modular step definitions
- CRUD + full lifecycle feature set
- Individual runners + 1 E2E scenario

---
