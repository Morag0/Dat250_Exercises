<script>
    export let poll;

    async function upvote(index) {
        poll.options[index].votes += 1;
        const response = await fetch(`/polls/${poll.id}/options/${index}/upvote`, {
        method: 'POST'
    });

    if (!response.ok) {
        console.error('Failed to upvote');
        poll.options[index].votes -= 1;
    } else {
        console.log('Upvoted successfully');
    }
    }

    async function downvote(index) {
        poll.options[index].votes -= 1;
        // Send the update to the backend
    const response = await fetch(`/polls/${poll.id}/options/${index}/downvote`, {
        method: 'POST'
    });

    if (!response.ok) {
        console.error('Failed to downvote');
        poll.options[index].votes += 1;
    } else {
        console.log('Downvoted successfully');
    }
    }
</script>

<div>
    <h2>{poll.question}</h2>
    {#each poll.options as option, index}
        <div>
            <span>{option.caption}</span> <!-- Ensure this matches your data structure -->
            <button type="button" on:click={() => upvote(index)}>upvote</button>
            <button type="button" on:click={() => downvote(index)}>downvote</button>
            <span>{option.votes} Votes</span>
        </div>
    {/each}
</div>