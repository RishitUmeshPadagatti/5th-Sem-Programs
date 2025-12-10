# Create Simulator object
set ns [new Simulator]

# Open NAM trace file
set nf [open lab1.nam w]
$ns namtrace-all $nf

# Open trace file
set tf [open lab1.tr w]
$ns trace-all $tf

# Define finish procedure
proc finish {} {
    global ns nf tf
    $ns flush-trace
    close $nf
    close $tf
    exec nam lab1.nam &
    exit 0
}

# Create four nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

# Create duplex links
$ns duplex-link $n0 $n2 200Mb 10ms DropTail
$ns duplex-link $n1 $n2 100Mb 5ms DropTail
$ns duplex-link $n2 $n3 1Mb 1000ms DropTail

# Set queue limits
$ns queue-limit $n0 $n2 10
$ns queue-limit $n1 $n2 10

# Create UDP and CBR agents for Node 0
set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0

set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

# Create UDP and CBR agents for Node 1
set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1

set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1

# Receiver agent
set null0 [new Agent/Null]
$ns attach-agent $n3 $null0

# Connect agents
$ns connect $udp0 $null0
$ns connect $udp1 $null0

# Schedule events
$ns at 0.1 "$cbr0 start"
$ns at 0.2 "$cbr1 start"
$ns at 1.0 "finish"

# Run simulation
$ns run
