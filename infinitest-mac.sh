fswatch -o --include='clj$' --exclude='.*' . | xargs -n1 -I{} lein test
