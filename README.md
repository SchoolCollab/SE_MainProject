# SE_MainProject

## Workflow Guide

### 1. Creating a New Issue

- **Create a new issue in `Linear`**
  - Press `c` on your keyboard or click the `+` at the top of the Todo list.
- **Naming Convention:**  
  `[LABEL] What the issue is about`
  - **Label:** Use capital letters inside brackets, e.g. `[FEAT]` for Feature, `[BUG]` for Bug, `[ENH]` for Enhancement, or `[DOC]` for Documentation, etc.
  - **Issue Name:** Summarize the issue in one sentence, e.g. `Implement interface for writing to/reading from database`.
- **Add a Summary (if necessary):**
  - **For bugs (recommended):**
    - Steps to reproduce the bug
    - Potential causes
    - Proposed approach to fix the bug
  - **For new features/enhancements (if large):**
    - Modules/scripts/functions involved
    - How it will improve the codebase
- **Label the issue.**
- **Assign the responsible person** (typically the creator).

---

### 2. Working on the Issue

- Go to the connected GitHub issue.
- **Create a new branch** for your work.

#### Commit Guidelines

- **Commit regularly.**
  - Divide your work into logical parts.  
    _Example:_ For "Implement interface for writing to/reading from database", you might have:
    - Add interface class to communicate with MongoDB
    - Replace direct MongoDB calls with interface functions
  - Add files related to the current part (usually one file at a time).
- **Commit message convention:**  
  `[label] what the commit is about`
  - Use the same labels as above. For bug fixes, use `[fix]`.
  - Summarize the commit in one sentence, e.g. `add interface class to communicate with MongoDB`.
- **Fetch and pull before pushing** (highly recommended).

---

### 3. Making a Pull Request

- **Create a pull request** (PR).
  - Name the PR (typically the same as the issue's name).
- **Request reviews** from other members.
  - Wait for at least 2 reviews before merging.
  - Try to resolve all comments before merging.
  - Communicate with reviewers to address change requests.
- **Resolve conflicts** if your branch conflicts with the main branch.

---

_This workflow helps ensure code quality, traceability, and smooth collaboration._