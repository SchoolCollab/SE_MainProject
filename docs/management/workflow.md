# SportNexus Workflow Guide

This document outlines the recommended workflow for managing issues, branches, commits, and pull requests in the SportNexus project. Following this workflow ensures code quality, traceability, and smooth collaboration.

***

## 1. Creating a New Issue

- **Create a new issue in Linear**
  - Press `c` or click the `+` at the top of the Todo list.
- **Naming Convention:**  
  `[LABEL] Brief description of the issue`
  - **Label:** Use capital letters in brackets, e.g. `[FEAT]` (Feature), `[BUG]` (Bug), `[ENH]` (Enhancement), `[DOC]` (Documentation), etc.
  - **Description:** Summarize the issue in one sentence, e.g. `Implement interface for database access`.
- **Add a Detailed Summary (if necessary):**
  - **For bugs:**  
    - Steps to reproduce  
    - Expected vs. actual behavior  
    - Potential causes  
    - Proposed fix or workaround
  - **For features/enhancements:**  
    - Modules/components affected  
    - User stories or acceptance criteria  
    - How it improves the project
- **Label the issue** appropriately.
- **Assign the issue** to the responsible team member.

***

## 2. Working on an Issue

- **Reference the issue** in GitHub (link Linear and GitHub if possible).
- **Create a new branch** from the latest `main` (or relevant base) branch:
    ```sh
    git checkout main
    git pull
    git checkout -b [label]/short-description
    ```
    _Example: `feat/database-interface` or `bug/login-error`_
- **Keep your branch focused** on the issue at hand.

### Commit Guidelines

- **Before committing, always run the code formatter:**
    ```sh
    ./scripts/format.sh
    ```
- **Commit frequently and logically.**
  - Break your work into small, meaningful commits.
  - Each commit should represent a single logical change.
- **Commit message format:**  
  `[label] Short description of the change`
  - Use the same labels as issues.
  - Example: `[feat] add interface for database access`
- **Pull before you push:**  
  - Always fetch and merge the latest changes from the base branch before pushing.
    ```sh
    git fetch origin
    git merge origin/main
    ```
- **Push your branch** to the remote repository when ready.

***

## 3. Making a Pull Request (PR)

- **Open a pull request** from your feature/bugfix branch to the `main` branch.
- **PR title:**  
  - Use the same format as the issue, e.g. `[FEAT] Implement database interface`
- **PR description:**  
  - Reference the related issue (e.g., `Closes #123`)
  - Summarize the changes and any important context.
  - List any follow-up tasks or known issues.
- **Request reviews** from at least 2 team members.
- **Address all review comments** and resolve any requested changes.
- **Resolve merge conflicts** if they arise.
- **Do not merge until**:
  - All required checks pass
  - At least 2 approvals are received
  - All comments are addressed

***

## 4. Merging and Closing

- **Squash and merge** commits for a clean history (unless otherwise agreed).
- **Close the related issue** automatically by referencing it in the PR (e.g., `Closes #123`).
- **Delete the feature/bugfix branch** after merging.

***

## Summary Table

| Step            | Main Actions                                                              |
| --------------- | ------------------------------------------------------------------------- |
| Create Issue    | Use Linear, follow naming conventions, add details, assign responsibility |
| Branch & Commit | Create focused branch, commit logically, follow message conventions       |
| Pull Request    | Open PR, reference issue, request reviews, resolve comments/conflicts     |
| Merge & Close   | Squash & merge, close issue, delete branch                                |

***

_Adhering to this workflow helps maintain a high-quality, collaborative, and efficient development process_