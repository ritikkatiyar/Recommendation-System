# Copilot Instructions for Fitness App Frontend

## Project Overview
This is a React application bootstrapped with Vite. The codebase is organized for modularity and maintainability, focusing on fitness activity management.

## Architecture & Key Components
- **Entry Point:** `src/main.jsx` initializes the app and sets up routing.
- **Root Component:** `src/App.jsx` is the main layout and navigation hub.
- **Components:**
  - `src/components/ActivityList.jsx`: Displays a list of activities.
  - `src/components/ActivityDetail.jsx`: Shows details for a selected activity.
  - `src/components/ActivityForm.jsx`: Handles creation/editing of activities.
- **State Management:**
  - Uses Redux Toolkit (`src/store/store.js`, `src/store/authSlice.js`).
  - Auth state and actions are defined in `authSlice.js`.
- **API Integration:**
  - All API calls are abstracted in `src/services/api.js`.
  - Use provided functions for backend communication; do not hardcode fetch/axios calls in components.
- **Auth Config:**
  - `src/authConfig.js` contains authentication configuration (e.g., tokens, endpoints).

## Developer Workflows
- **Start Dev Server:**
  - `npm run dev` (uses Vite for fast refresh)
- **Build for Production:**
  - `npm run build`
- **Linting:**
  - `npm run lint` (ESLint config in `eslint.config.js`)
- **No test scripts or test files are present.**

## Conventions & Patterns
- **Component Structure:**
  - Use functional components and hooks (no class components).
  - Keep UI logic in components, business logic in services or store.
- **Redux Usage:**
  - Use slices for state domains (see `authSlice.js`).
  - Dispatch actions via hooks (`useDispatch`, `useSelector`).
- **API Calls:**
  - Centralize all HTTP requests in `api.js`.
  - Handle errors and responses in service layer, not in UI components.
- **Styling:**
  - Use CSS files per component (e.g., `App.css`).

## External Dependencies
- **React** (UI)
- **Redux Toolkit** (state management)
- **Vite** (build tool)
- **ESLint** (linting)

## Examples
- To add a new activity, create a form in `ActivityForm.jsx` and dispatch an action to the store.
- To fetch activities, use the API abstraction in `api.js` and update state via Redux actions.

## Key Files
- `src/App.jsx`, `src/main.jsx`, `src/components/`, `src/services/api.js`, `src/store/`

---
For questions or unclear conventions, ask for clarification or review recent code in the referenced files above.
