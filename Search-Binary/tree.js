import { insertValue, removeValue, findValue } from "./node";

export class Tree {

    constructor() {
        this.root = "";
    }

    insert(value) {

        if (typeof value === "undefined") { return; }

        this.root = insertValue(this.root, value);
    }

    remove(value) {

        this.root = removeValue(this.root, value);
    }

    find(value) {

        return findValue(this.root, value);
    }
}